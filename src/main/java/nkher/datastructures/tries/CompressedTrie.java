package nkher.datastructures.tries;

import nkher.interfaces.MyTrie;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class CompressedTrie extends Trie implements MyTrie {

    private CompressedTrieNode root;
    private HashSet<String> dictionary;

    private class CompressedTrieNode {
        private String data;
        private String parentData;
        private boolean leaf;
        private HashMap<String, CompressedTrieNode> children;

        public CompressedTrieNode(String data, String parent) {
            this.data = data;
            this.parentData = parent;
            children = new HashMap<>();
        }

        public void setAsLeaf() {
            this.leaf = true;
        }

        public boolean isLeaf() {
            return (leaf == true);
        }

        public void addChild(String ch, String parentData) {
            children.put(ch, new CompressedTrieNode(ch, parentData));
        }

        public void removeChild(String ch) {
            children.remove(ch);
        }

        public String toString() {
            return "(" + data + "," + parentData + "," + leaf + ")";
        }

        public boolean hasChildren() {
            return (children.size() > 0);
        }
    }

    public CompressedTrie() {
        root = new CompressedTrieNode("$", "n");
        dictionary = new HashSet<>();
    }


    @Override
    public void insert(String key) {

    }

    @Override
    public boolean contains(String key) {
        return false;
    }

    @Override
    public List<String> prefixSearch(String prefixKey) {
        return null;
    }

    @Override
    public boolean containsPrefix(String prefixKey) {
        return false;
    }

    @Override
    public boolean removeKey(String key) {
        return false;
    }
}
