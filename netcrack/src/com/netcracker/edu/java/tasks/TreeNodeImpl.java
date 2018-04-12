package com.netcracker.edu.java.tasks;

import java.util.ArrayList;
import java.util.Iterator;

public class TreeNodeImpl implements TreeNode {
    private TreeNode parent = null;
    private ArrayList<TreeNode> children = new ArrayList<TreeNode>();
    private boolean expanded = false;
    private Object data = null;
    @Override
    public TreeNode getParent() {
        return parent;
    }

    @Override
    public void setParent(TreeNode parent) {
        this.parent = parent;
    }

    @Override
    public TreeNode getRoot() {
        if(parent == null){
            return null;
        }
        return parent.getRoot();
    }

    @Override
    public boolean isLeaf() {
        if(this.children.size() == 0)
            return true;
        else
            return false;
    }

    @Override
    public int getChildCount() {
        return this.children.size();
    }

    @Override
    public Iterator<TreeNode> getChildrenIterator() {
        return this.children.iterator();
    }

    @Override
    public void addChild(TreeNode child) {
        child.setParent(this);
        this.children.add(child);
    }

    @Override
    public boolean removeChild(TreeNode child) {
        if(children.contains(child)){
            child.setParent(null);
            this.children.remove(child);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isExpanded() {
        return expanded;
    }

    @Override
    public void setExpanded(boolean expanded) {
        this.expanded = expanded;
        Iterator<TreeNode> iterator = children.listIterator();
        while (iterator.hasNext()){
            TreeNode elem = iterator.next();
            elem.setExpanded(expanded);
        }
    }

    @Override
    public Object getData() {
        return this.data;
    }

    @Override
    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String getTreePath() {
        return null;
    }

    @Override
    public TreeNode findParent(Object data) {
        return null;
    }

    @Override
    public TreeNode findChild(Object data) {
        return null;
    }

    public static void main(String[] args) {
        TreeNodeImpl leaf = new TreeNodeImpl();
        TreeNodeImpl leaf2 = new TreeNodeImpl();
        leaf.setParent(leaf2);
        leaf.getRoot();
        leaf2.setExpanded(true);
    }
}
