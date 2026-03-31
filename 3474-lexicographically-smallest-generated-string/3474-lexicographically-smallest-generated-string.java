class Solution {
    public String generateString(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        char[] res = new char[n + m - 1];
        boolean[] fixed = new boolean[n + m - 1];

        for(int i = 0; i < res.length; i++) {
            res[i] = '?';
        }

        for(int i = 0; i < n; i++) {
            if(str1.charAt(i) == 'T') {
                for(int j = 0; j < m; j++) {
                    char curr = str2.charAt(j);

                    if(res[i + j] == '?' || res[i + j] == curr) {
                        res[i + j] = curr;
                        fixed[i + j] = true;
                    } else {
                        return "";
                    }
                }
            }
        }

        for(int i = 0; i < res.length; i++) {
            if(res[i] == '?') {
                res[i] = 'a';
            }
        }

        for(int i = 0; i < n; i++) {
            if(str1.charAt(i) == 'F') {
                boolean match = true;

                for(int j = 0; j < m; j++) {
                    if(res[i + j] != str2.charAt(j)) {
                        match = false;
                        break;
                    }
                }

                if (match) {
                    boolean changed = false;

                    for(int j = m - 1;j >= 0; j--) {
                        int idx = i + j;
                        if ( fixed[idx]) continue;

                        for(char c = 'a'; c <= 'z'; c++) {
                            if (c != str2.charAt(j)) {
                                res[idx] = c;
                                changed = true;
                                break;
                            }
                        }
                        if (changed) break;
                    }
                    if (!changed) return "";
                }
            }

        }
        return new String(res);
    }
}