
# Time: O(n^2) as we are recursing
# Space: O(n^2) as we are creating extra arrays at every node call

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        
        if len(preorder) == 0:
            return None
        
        rootval = preorder[0]
        root = TreeNode(rootval)
        rooindex = -1
        

        # O(n) time
        for i in range(len(inorder)):
            if rootval == inorder[i]:
                rootindex = i
                break
        
        # O(n) time
        inleft = inorder[0:rootindex].copy()
        inright = inorder[rootindex+1:].copy()
        preleft = preorder[1:rootindex+1].copy()
        preright = preorder[rootindex+1:].copy()
        
        root.left = self.buildTree(preleft, inleft)
        root.right = self.buildTree(preright, inright)
        return root



