class TextEditor {
public:
    string a,b;
    
    void addText(string text) {
        a.insert(a.end(),text.begin(),text.end());
    }
    
    int deleteText(int k) {
        int del=min((int)a.size(),k);
        a.resize(a.size()-del);
        return del;
    }
    
    string cursorLeft(int k) {
        while(k>0 && a.size()>0){
            b.push_back(a.back());
            a.pop_back();
            k--;
        }
        int len=min(10,(int)a.size());
        return a.substr(a.size()-len,len);
    }
    
    string cursorRight(int k) {
        while(k>0 && b.size()>0){
            a.push_back(b.back());
            b.pop_back();
            k--;
        }
        int len=min(10,(int)a.size());
        return a.substr(a.size()-len,len);
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