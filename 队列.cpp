#include<cstdio>
#include<iostream>
#define MAXSIZE 10
using namespace std;


struct QNode{
    char *name[100];
    int front;
    int rear;
    int MaxSize;
};
typedef QNode *PtrToQNode;
typedef PtrToQNode Queue;

Queue CreateQueue(int MaxSize){
    Queue Q = (Queue)malloc(sizeof(struct QNode));
    for (int i = 0; i<MaxSize;i++)
    {
        /* code */
        Q->name[i] = (char*)malloc(sizeof(char)*MAXSIZE);
    }
    
    
    Q->front = 0;
    Q->rear = 0;
    Q->MaxSize = MaxSize;
    return Q; 
}

bool AddQueue(Queue Q, char *s){
    if((Q->rear+1)%Q->MaxSize == Q->front){
        cout<<"FULL"<<endl;
        return false;
    }else{
        Q->rear = (Q->rear + 1) % Q->MaxSize;
        //cin>>Q->name[Q->rear] ;
        Q->name[Q->rear] = s;
        return true;
    }
}
int QueueEmpty(Queue Q){
   if(Q->front == Q->rear){
        return 1;
    }
   else
       return 0;
}

char* DeleQu(Queue Q){
    char *s;
    if(Q->front == Q->rear){
        cout<<"empty"<<endl;
        
        return 0;
    }else{
        Q->front = (Q->front+1)%Q->MaxSize;
        s = Q->name[Q->front];
        return s;
    }
}

int main(){
    int m,f,T,tmp1,tmp2;  // m男，f女,T轮数
    
    cin>>m;
    Queue Q_M = CreateQueue(m+1);
    char *tmp_M[10], *tmp_F[10];

    for(int i=0;i<m;i++){
        //cout<<m<<" "<<i;
        tmp_M[i] = (char*)malloc(sizeof(char)*MAXSIZE);  //名字一般不会特别长
        cin>>tmp_M[i];
        AddQueue(Q_M,tmp_M[i]);
        // cout<<tmp_M[i];
    }
    
    
    cin>>f;
    Queue Q_F = CreateQueue(f+1);
    for(int i=0;i<f;i++){
        tmp_F[i] = (char*)malloc(sizeof(char)*MAXSIZE);
        cin>>tmp_F[i];
        AddQueue(Q_F,tmp_F[i]);
        // cout<<tmp_M[i];
    }
    cin>>T;
    int count_m = 0, count_f = 0, count_t = 1;

    while(T--){
        tmp1 = m;tmp2 = f;
        int t = min(m,f);
        cout<<count_t++<<".";
        while(t--){
            //cout<<"<"<<Q_M->data[i]
            
            char *t_M,*t_F;
            t_M = DeleQu(Q_M);
            AddQueue(Q_M,tmp_M[count_m]);
            t_F = DeleQu(Q_F);
            AddQueue(Q_F,tmp_F[count_f]);
            cout<<"<"<<t_M<<","<<t_F<<">"<<" ";
            count_m = (count_m+1) % m;
            count_f = (count_f+1) % f;

            //cout<<" "<<;
        }
        cout<<""<<endl;
        
    }
    
    for(int i=0;i<f;i++){
        free(tmp_M[i]);
        free(tmp_F[i]);
        // cout<<tmp_M[i];
    }
    
    free(Q_F);
    free(Q_M);
    
    return 0;
    
    
}