package ueb02;

import java.util.NoSuchElementException;

public class StringSetImpl implements StringSet {
    class Element{
        String value;
        Element left, right;

        Element(String c, Element left, Element right)
        {
            value = c;
            this.left = left;
            this.right = right;
        }
        int Size(){
            return 1 + (left == null ? 0 : left.Size()) + (right == null ? 0 : right.Size());
        }
        public String toString(){
            return value + (left == null ? "": "," + left) + (right == null ? "" : "," + right);
        }
    }
    Element root;
    @Override
    public boolean add(String s) {
        return addElement(new Element(s, null, null));
    }
    private boolean addElement(Element e) {
        if (e == null) return false;
        if (root == null) {
            root = e;
            return true;
        }
        Element s = root;
        while (s != null) {
            int a = e.value.compareTo(s.value);
            if (a == 0) return false;
            else if (a < 0) {
                s.left = e;
                return true;
            } else {
                s = s.left;
            }
            if (a > 0) {
                s.right = e;
                return true;
            } else {
                s = s.right;
            }
            return false;

        }
    return false;
    }

    @Override
    public boolean contains(String s) {
        if(root == null) return false;
        Element stash = root;
        while(stash != null){
            int b = s.compareTo(stash.value);
            if(b < 0) stash = stash.left;
            if(b > 0) stash = stash.right;
            if(b == 0) return true;
        }
        return false;
    }

    @Override
    public int size() {
        return root.Size();
    }

    @Override
    public String remove(String s) {
        if(root == null)
            throw new NoSuchElementException();
        Element stash = root;
        while(stash != null) {

        }
        return null;
    }
}

