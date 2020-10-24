#include <iostream>
#include <set> // track the pages
#include <vector> // nodes
#include <map> // page number to page nodes
#include <memory> // shared_ptr

using namespace std;

typedef struct node 
{
    int value;
    vector< shared_ptr<struct node> > children;
} node_t;


int findShortestPath(vector< shared_ptr<node_t>> nodes, int level)
{
    ++level;
    vector< shared_ptr<node_t> > childNodes;
    for (auto node : nodes)
    {
        if (node->children.size() == 0)
        {
            return level;
        }
        else 
        {
            for (auto a: node->children)
            {
                childNodes.push_back(a);
            }
        }
    }
    
    return findShortestPath(childNodes, level);
}

void getReachablePages(shared_ptr<node_t> node, set<int>& pages)
{
    if (pages.find(node->value) == pages.end())
    {
        pages.insert(node->value);
        for (auto a: node->children)
        {
            getReachablePages(a, pages);
        }
    }
}

int main() 
{
    int n;
    cin >> n;
    map< int, shared_ptr<node_t> > pageMap;
    for (int i = 0; i < n; ++i)
    {
        pageMap[i+1] = make_unique<node_t>();
        pageMap[i+1]->value = i + 1;
    }

    for (int i = 1; i <= n; ++i)
    {
        int num = 0;
        cin >> num;
        for (int j = 0; j < num; ++j)
        {
            int page = 0;
            cin >> page;
            pageMap[i]->children.push_back(pageMap[page]);
        }
    }

    // do we have all the pages?
    set<int> pages;
    getReachablePages(pageMap[1], pages);
    if (pages.size() == n)
    {
        cout << "Y" << endl;
    }
    else 
    {
        cout << "N" << endl;
    }

    // find the shortest path
    int level = 0;
    vector< shared_ptr<node_t> > nodesToCheck;
    nodesToCheck.push_back(pageMap[1]); // check from page 1
    cout << findShortestPath(nodesToCheck, level) << endl;
}