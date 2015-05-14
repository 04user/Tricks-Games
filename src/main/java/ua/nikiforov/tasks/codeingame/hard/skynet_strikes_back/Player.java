//package ua.nikiforov.tasks.codeingame.hard.skynet_strikes_back;

import java.util.*;
import java.util.concurrent.ConcurrentLinkedDeque;

class Player {
    private static Map<Integer, Node> nodes;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int totalNumberOfNodes = in.nextInt();
        int numberOfLinks = in.nextInt();
        int numberOfExitGateway = in.nextInt();

        nodes = new HashMap<>(totalNumberOfNodes);

        for (int i = 0; i < numberOfLinks; i++) {
            int idxFirstNode = in.nextInt();
            int idxSecondNode = in.nextInt();

            createLink(idxFirstNode, idxSecondNode);
        }

        for (int i = 0; i < numberOfExitGateway; i++) {
            int idxOfGatewayNode = in.nextInt();
            nodes.get(idxOfGatewayNode).isExitGateway = true;
        }

        while (true) {
            int agentIdx = in.nextInt(); // The index of the node on which the Skynet agent is positioned this turn

            int[] link = findLinkForSever(agentIdx);

            System.out.println(link[0] + " " + link[1]); // Example: 0 1 are the indices of the nodes you wish to sever the link between
        }
    }

    private static void createLink(int firstNode, int secondNode) {
        nodes.computeIfAbsent(firstNode, id -> nodes.put(id, new Node()));
        nodes.computeIfAbsent(secondNode, id -> nodes.put(id, new Node()));

        nodes.get(firstNode).neighbours.add(secondNode);
        nodes.get(secondNode).neighbours.add(firstNode);
    }

    private static int[] findLinkForSever(int agentIdx) {
        Deque<Integer> queue = new ConcurrentLinkedDeque<>();
        Set<Integer> discovered = new LinkedHashSet<>();
        queue.addLast(agentIdx);

        if (nodes.get(agentIdx).neighbours.size() < 3) {
            Integer[] nds = nodes.get(agentIdx).neighbours.toArray(new Integer[nodes.get(agentIdx).neighbours.size()]);
            int nd;
            /*if (nds.length == 1) {
                nd = nds[0];
            }*/
            if (nds.length == 2) {
                if (nodes.get(nds[0]).isExitGateway) {
                    nd = nds[0];
                } else if (nodes.get(nds[1]).isExitGateway) {
                    nd = nds[1];
                } else if (nodes.get(nds[0]).neighbours.size() > nodes.get(nds[1]).neighbours.size()) {
                    nd = nds[0];
                } else {
                    nd = nds[1];
                }
                removeLink(agentIdx, nd);
                return new int[]{agentIdx, nd};
            }
        }


        while (!queue.isEmpty()) {
            final Integer comparedNode = queue.pollFirst();
            discovered.add(comparedNode);
            Set<Integer> neighbours = nodes.get(comparedNode).neighbours;

            System.err.println("discovered : " + discovered);
            System.err.println("queue : " + queue);

            for (Integer nextNeighbour : neighbours) {
                if (!discovered.contains(nextNeighbour)) {
                    if (nodes.get(nextNeighbour).isExitGateway) {
                        removeLink(comparedNode, nextNeighbour);
                        return new int[]{comparedNode, nextNeighbour};
                    } else {
                        queue.addLast(nextNeighbour);
                    }
                }
            }
        }

        return new int[]{0, 0};
    }

    private static void removeLink(Integer firstIdx, Integer secondIdx) {
        nodes.get(firstIdx).neighbours.remove(secondIdx);
        nodes.get(secondIdx).neighbours.remove(firstIdx);
    }

    static class Node {
        private boolean isExitGateway = false;
        private Set<Integer> neighbours = new HashSet<>();
    }
}