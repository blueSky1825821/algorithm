package binarytree;

public class TreeNodeB {
    public Integer value;
    public TreeNodeB left;
    public TreeNodeB right;

    public TreeNodeB() {
    }

    public TreeNodeB(Integer value) {
        this.value = value;
    }

    public TreeNodeB(Integer value, TreeNodeB left, TreeNodeB right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
