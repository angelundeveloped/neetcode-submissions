impl Solution {
    pub fn is_anagram(s: String, t: String) -> bool {

        if s.len() != t.len() {
            return false;
        }

        let mut char_count = [0; 26];
        let s_bytes = s.as_bytes();
        let t_bytes = t.as_bytes();

        for i in 0..s_bytes.len() {
            char_count[(s_bytes[i] - b'a') as usize] += 1;
            char_count[(t_bytes[i] - b'a') as usize] -= 1;
        }

        for val in char_count {
            if val != 0 { return false; }
        }

        return true;
    }
}
