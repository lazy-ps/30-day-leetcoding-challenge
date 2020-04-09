class Solution {
public:
    void backspace(string &str)
    {
        int i, cursor;
        for(i=0, cursor=0; i<str.size(); i++)
        {
            if(str[i] == '#')
            {
                if(cursor > 0)
                    cursor--;
            }
            else
                str[cursor++] =str[i];
        }
        if(i != cursor)
            str[cursor] = '#';
    }
    
    bool backspaceCompare(string S, string T) {
        backspace(S);
        backspace(T);
        for(int i=0; i<S.size(); i++)
        {
            if(S[i] != T[i])
                return false;
            else if(S[i] == '#')
                break;
        }
        return true;
    }
};
