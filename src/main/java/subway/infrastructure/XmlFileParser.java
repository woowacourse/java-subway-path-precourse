package subway.infrastructure;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XmlFileParser extends FileParser {
    private static final int UNKNOWN_NODE_LIST = 0;
    private static final int HAS_ELEMENT_NODE_LIST = 1;
    private static final int HAS_TEXT_NODE_LIST = 2;

    private final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

    public XmlFileParser(String fileName) {
        super(fileName);
    }

    public XmlFileParser(File file) {
        super(file);
    }

    @Override
    public boolean allowExtension(String extension) {
        return "xml".equals(extension);
    }

    @Override
    public List<Map<String, Object>> parser() {
        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document document = builder.parse(file);
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();
            return this.find(root);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private List<Map<String, Object>> find(Element root) {
        List<Map<String, Object>> data = new ArrayList<>();
        NodeList nodeList = root.getChildNodes();
        for (int index = 0; index < nodeList.getLength(); index++) {
            Node node = nodeList.item(index);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                data.add(this.serialize(node.getChildNodes()));
            }
        }
        return data;
    }

    private Map<String, Object> serialize(NodeList parentNodeList) {
        Map<String, Object> data = new HashMap<>();
        for (int index = 0; index < parentNodeList.getLength(); index++) {
            Node child = parentNodeList.item(index);
            int childType = child.getNodeType();
            String childName = child.getNodeName();
            if (childType == Node.ELEMENT_NODE) {
                data.put(childName, this.getNodeData(child));
            }
        }
        return data;
    }

    private Object getNodeData(Node node) {
        NodeList nodeList = node.getChildNodes();
        int nodeListType = this.getNodeListType(nodeList);
        if (nodeListType == HAS_ELEMENT_NODE_LIST) {
            return this.serialize(nodeList);
        } else if (nodeListType == HAS_TEXT_NODE_LIST) {
            return this.getTextValue(node);
        }
        return null;
    }

    private int getNodeListType(NodeList nodeList) {
        for (int index = 0; index < nodeList.getLength(); index++) {
            Node node = nodeList.item(index);
            int nodeType = node.getNodeType();
            String _nodeValue = node.getNodeValue();
            if (nodeType == Node.ELEMENT_NODE) {
                return HAS_ELEMENT_NODE_LIST;
            } else if (nodeType == Node.TEXT_NODE && this.hasTextValue(_nodeValue)) {
                return HAS_TEXT_NODE_LIST;
            }
        }
        return UNKNOWN_NODE_LIST;
    }

    private String getTextValue(Node node) {
        NodeList nodeList = node.getChildNodes();
        for (int index = 0; index < nodeList.getLength(); index++) {
            Node child = nodeList.item(index);
            String _childValue = child.getNodeValue();
            if (child.getNodeType() == Node.TEXT_NODE && this.hasTextValue(_childValue)) {
                return _childValue.trim();
            }
        }
        return "";
    }

    private boolean hasTextValue(String value) {
        return value != null && !value.trim().isEmpty();
    }
}
