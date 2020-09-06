class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = travel(root1);
        result.addAll(travel(root2));
        result.sort(null);

        return result;
    }

    List<Integer> travel(TreeNode root) {
        if(root == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        result.add(root.val);
        result.addAll(travel(root.left));
        result.addAll(travel(root.right));

        return result;
    }
}
