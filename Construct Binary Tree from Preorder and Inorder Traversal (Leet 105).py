
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



# Binary Search (Efficient)
# Time: O(n)
# Space: O(n)

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    index = 0
    hm = dict()
    def buildTree(self, preorder: List[int], inorder: List[int]) -> Optional[TreeNode]:
        self.hm = dict()
        self.index = 0
        for i in range(len(inorder)):
            self.hm[inorder[i]] = i
        
        
        return self.helper(preorder, 0, len(inorder)-1)
    
    def helper(self, preorder, start, end):
        if start > end:
            return None
        
        rootval = preorder[self.index]
        self.index += 1
        rootindex = self.hm[rootval]
        
        root = TreeNode(rootval)
        
        root.left = self.helper(preorder, start, rootindex-1)
        root.right = self.helper(preorder, rootindex+1, end)
        return root


