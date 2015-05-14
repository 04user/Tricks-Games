package ua.nikiforov.tasks.codeingame.contest.thereisnospoon.task2;

import java.util.*;

/**
 * https://en.wikipedia.org/wiki/Hashiwokakero
 *
 * @author Sergey Nikiforov
 */
class Player {
    private static final char EMPTY_CELL = '.';
    private static char[][] field;
    private static Set<Node> nodes = new HashSet<>();

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int width = in.nextInt();
        in.nextLine();
        int height = in.nextInt();
        in.nextLine();
        field = new char[height][width];

        for (int y = 0; y < height; y++) {
            String line = in.nextLine(); // width characters, each either a number or a '.'
            for (int x = 0; x < width; x++) {
                field[y][x] = line.charAt(x);
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                if (field[y][x] == EMPTY_CELL) {
                    continue;
                }

                // looking first
                buildNode(x, y);
            }
        }
    }



    private static void buildNode(int x, int y) {
        Node node = new Node(x, y, field[y][x]);
        nodes.add(node);

        lookingNeighbours(node);
        establishLinks(node);
        node.printLinks();
    }

    private static void establishLinks(Node node) {
        int neighboursNumber = node.getNeighbours().size();
        if (neighboursNumber == 1) {
            Node first = node.getNeighbours().stream().findFirst().get();
            node.addLink(first, node.getWeight());
        } else {
//            node.getNeighbours().parallelStream().collect(Integer::new, (r, node1) -> node1.get)
        }
    }

    private static void lookingNeighbours(Node node) {
        if (rightNeighbourExist(node)) {
            Node neighbour = getNode(new Node(node.x + 1, node.y, field[node.y][node.x + 1]));
            node.addNeighbour(neighbour);
        }

        if (bottomNeighbourExist(node)) {
            Node neighbour = getNode(new Node(node.x, node.y + 1, field[node.y + 1][node.x]));
            node.addNeighbour(neighbour);
        }
    }

    private static Node getNode(Node node) {
        if (nodes.contains(node)) {
            for (Node next : nodes) {
                if (next.equals(node)) {
                    return next;
                }
            }
        }
        nodes.add(node);
        return node;
    }

    private static boolean bottomNeighbourExist(Node node) {
        return field[node.y + 1][node.x] != EMPTY_CELL;
    }

    private static boolean rightNeighbourExist(Node node) {
        return field[node.y][node.x + 1] != EMPTY_CELL;
    }

    static class Node {
        final int x;
        final int y;
        private int weight;
        private Set<Node> neighbours = new HashSet<>(4);
        private List<Link> links = new ArrayList<>();

        public Node(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Node(int x, int y, int weight) {
            this(x, y);
            this.weight = weight;
        }

        public void addNeighbour(Node neighbour) {
            neighbours.add(neighbour);
            neighbour.getNeighbours().add(this);
        }

        public void removeNeighbour(Node neighbour) {
            neighbours.remove(neighbour);
            neighbour.getNeighbours().remove(this);
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }

        public int getWeight() {
            return weight;
        }

        public Set<Node> getNeighbours() {
            return neighbours;
        }

        public void addLink(Node neighbour, int amount) {
            Link link = new Link(neighbour, amount);
            links.add(link);
            Link ourLink = new Link(this, amount);
            neighbour.getLinks().add(ourLink);
        }

        public void removeLink(Link link) {
            links.remove(link);
            link.node.getLinks().remove(link);
        }

        public List<Link> getLinks() {
            return links;
        }

        public void setLinks(List<Link> links) {
            this.links = links;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Node node = (Node) o;

            return x == node.x && y == node.y;

        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }

        public void printLinks() {
            for (Link link : links) {
                StringBuilder builder = new StringBuilder().append(x).append(" ").append(y).append(" ")
                        .append(link.node.x).append(" ").append(link.node.y).append(" ").append(link.amount);
                System.out.println(builder.toString());

                links.remove(link);
                link.node.links.remove(link);
            }
        }


        class Link {
            private Node node;
            private int amount;

            public Link(Node node) {
                this.node = node;
                amount = 1;
            }

            public Link(Node node, int amount) {
                this.node = node;
                this.amount = amount;
            }
        }
    }
}
