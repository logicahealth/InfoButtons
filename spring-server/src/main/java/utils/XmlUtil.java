package utils;

import java.util.*;
import org.w3c.dom.*;

public final class XmlUtil {
    private XmlUtil(){}

    public static List<Node> asList(NodeList n) {
        return n.getLength()==0?
                Collections.<Node>emptyList(): new NodeListWrapper(n);
    }
    static final class NodeListWrapper extends AbstractList<Node>
            implements RandomAccess {
        private final NodeList list;
        NodeListWrapper(NodeList l) {
            list=l;
        }
        public Node get(int index) {
            return list.item(index);
        }
        public int size() {
            return list.getLength();
        }
    }
}