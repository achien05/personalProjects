from collections import defaultdict, deque
class Node:
    def __init__(self, data):
        self.data = data
        
class Graph:
    def __init__(self, num_nodes):
        self.num_nodes = num_nodes
        self.graph = defaultdict(list)
        self.in_degree = [0] * num_nodes
    def add_edge(self, from_node, to_node):
        self.graph[from_node].append(to_node)
        self.in_degree[to_node] += 1
    #def k_t_s():    #kahn topological sort