class Node: #defines a node
    def __init__(self,parent,step,ruleused,index,element): 
        self.parent = parent
        self.step = step
        self.ruleused = ruleused
        self.index = index
        self.element = element

def replace(s,rule,index):
    return s[:index]+subrulesend[rule]+s[index+len(subrulesstart[rule]):]

def composenew(node, sr, dr, stack):
    s = node.element
    for x in range(len(sr)):
        p = sr[x]
        d = dr[x]
        for j in range(len(s)):
            if s[j:len(p) + j] == p:
                stack.append(Node(node, node.step + 1, x+1, j+1, replace(s,x,j)))

def DFS(startrules,endrules,stepsneeded,start,neededelement):
    stack=[Node(None,0,None,None,start)]
    visited=[set() for i in range(stepsneeded)]
    while stack!=[]:
        curr=stack.pop()
        if curr.step==stepsneeded:
            if len(curr.element)!=len(neededelement):
                continue
        if curr.step>stepsneeded:
            continue
        if curr.step==stepsneeded-1:
            if len(curr.element)>len(neededelement):
                if len(curr.element)-len(subrulesstart[0])+len(subrulesend[0])!=len(neededelement) and len(curr.element)-len(subrulesstart[1])+len(subrulesend[1])!=len(neededelement) and len(curr.element)-len(subrulesstart[2])+len(subrulesend[2])!=len(neededelement):
                    continue
        if curr.element in visited[curr.step-1]:
            continue
        visited[curr.step-1].add(curr.element)
        if curr.step==stepsneeded:         
            if curr.element==neededelement:             
                return curr     
        composenew(curr, startrules, endrules, stack)

def parentchain(el):#gets final answer from last node
    l=[]
    while el.parent:
        l.append((el.ruleused,el.index,el.element))
        el=el.parent
    return l[::-1]
    
subrulesstart=[]
subrulesend=[]
rulelengths=set()
for i in range(3):
    inpt=input().rstrip().split()
    subrulesstart.append(inpt[0])
    subrulesend.append(inpt[1])
    rulelengths.add(len(inpt[0]))


# subrulesstart=['B','AB','B']
# subrulesend=['ABB','A','BB']
# rulelengths={1,2}
# inpt=[7,'AB','ABABAA']
inpt=input().rstrip().split()
stepsneeded=int(inpt[0])
start=inpt[1]
neededelement=inpt[2]
for i in parentchain(DFS(subrulesstart,subrulesend,stepsneeded,start,neededelement)):
    print(i[0],i[1],i[2])