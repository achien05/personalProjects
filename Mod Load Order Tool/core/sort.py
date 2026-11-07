def topoSort(input):
    input = input.sort(key=lambda x: x.name)    #largely referenced Kahn's algorithm: https://www.geeksforgeeks.org/dsa/topological-sorting-indegree-based-solution/
    n = len(input)
    indegree = [0]*n
    out = []
    queue = []
    
    for i in range(n):
        indegree[i] = (len(input[i].loadsAfter))    #relies on the indegree and input index corresponding
    
    for i in range(n):
        if indegree[i] == 0:
            queue.append(i)
            
    while queue:
        top = queue.pop(0)
        out.append(input[top].id)
        for i in n:
            if input[i].id in input[top].loadsBefore:
                indegree[i]-=1
                if indegree[i] == 0:
                    queue.append(i)
    return out
    
    
    
    