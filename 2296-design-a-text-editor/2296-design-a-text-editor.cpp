class TextEditor {
public:
    stack<char>a;
    stack<char>b;
    
    void addText(string text) {
        for(char c:text){
            a.push(c);
        }
    }
    
    int deleteText(int k) {
        int cnt=0;
        while(k>0 && a.size()>0){
            a.top();a.pop();
            k--;
            cnt++;
        }
        return cnt;
    }
    
    string cursorLeft(int k) {
        while(k>0 && a.size()>0){
            char c=a.top();a.pop();
            b.push(c);
            k--;
        }
        int temp=min(10,(int)a.size());
        int len=temp;
        string ret="";
        while(len>0){
            char c=a.top();a.pop();
            b.push(c);
            ret=c+ret;
            len--;
        }
        len=temp;
        while(len>0){
            char c=b.top();b.pop();
            a.push(c);
            len--;
        }
        return ret;
    }
    
    string cursorRight(int k) {
        while(k>0 && b.size()>0){
            char c=b.top();b.pop();
            a.push(c);
            k--;
        }
        int temp=min(10,(int)a.size());
        int len=temp;
        string ret="";
        while(len>0){
            char c=a.top();a.pop();
            b.push(c);
            ret=c+ret;
            len--;
        }
        len=temp;
        while(len>0){
            char c=b.top();b.pop();
            a.push(c);
            len--;
        }
        return ret;
    }
};

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor* obj = new TextEditor();
 * obj->addText(text);
 * int param_2 = obj->deleteText(k);
 * string param_3 = obj->cursorLeft(k);
 * string param_4 = obj->cursorRight(k);
 */