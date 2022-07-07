package algo;

import java.util.Arrays;
import java.util.List;

/**
 * @author jingtao
 * @date 2022/7/7 9:46 PM
 */
public class Trie {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceWords(Arrays.asList("e", "k", "c", "harqp", "h", "gsafc", "vn", "lqp", "soy", "mr", "x", "iitgm", "sb", "oo", "spj", "gwmly", "iu", "z", "f", "ha", "vds", "v", "vpx", "fir", "t", "xo", "apifm", "tlznm", "kkv", "nxyud", "j", "qp", "omn", "zoxp", "mutu", "i", "nxth", "dwuer", "sadl", "pv", "w", "mding", "mubem", "xsmwc", "vl", "farov", "twfmq", "ljhmr", "q", "bbzs", "kd", "kwc", "a", "buq", "sm", "yi", "nypa", "xwz", "si", "amqx", "iy", "eb", "qvgt", "twy", "rf", "dc", "utt", "mxjfu", "hm", "trz", "lzh", "lref", "qbx", "fmemr", "gil", "go", "qggh", "uud", "trnhf", "gels", "dfdq", "qzkx", "qxw"), "ikkbp miszkays wqjferqoxjwvbieyk gvcfldkiavww vhokchxz dvypwyb bxahfzcfanteibiltins ueebf lqhflvwxksi dco kddxmckhvqifbuzkhstp wc ytzzlm gximjuhzfdjuamhsu gdkbmhpnvy ifvifheoxqlbosfww mengfdydekwttkhbzenk wjhmmyltmeufqvcpcxg hthcuovils ldipovluo aiprogn nusquzpmnogtjkklfhta klxvvlvyh nxzgnrveghc mpppfhzjkbucv cqcft uwmahhqradjtf iaaasabqqzmbcig zcpvpyypsmodtoiif qjuiqtfhzcpnmtk yzfragcextvx ivnvgkaqs iplazv jurtsyh gzixfeugj rnukjgtjpim hscyhgoru aledyrmzwhsz xbahcwfwm hzd ygelddphxnbh rvjxtlqfnlmwdoezh zawfkko iwhkcddxgpqtdrjrcv bbfj mhs nenrqfkbf spfpazr wrkjiwyf cw dtd cqibzmuuhukwylrnld dtaxhddidfwqs bgnnoxgyynol hg dijhrrpnwjlju muzzrrsypzgwvblf zbugltrnyzbg hktdviastoireyiqf qvufxgcixvhrjqtna ipfzhuvgo daee r nlipyfszvxlwqw yoq dewpgtcrzausqwhh qzsaobsghgm ichlpsjlsrwzhbyfhm ksenb bqprarpgnyemzwifqzz oai pnqottd nygesjtlpala qmxixtooxtbrzyorn gyvukjpc s mxhlkdaycskj uvwmerplaibeknltuvd ocnn frotscysdyclrc ckcttaceuuxzcghw pxbd oklwhcppuziixpvihihp"));
    }
}

//https://leetcode.cn/problems/replace-words/
class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode trieNode = new TrieNode();
        dictionary.forEach(word -> buildTrie(word, trieNode));
        String[] words = sentence.split(" ");
        String[] ans = new String[words.length];
        for (int i = 0; i < words.length; i++) {
            ans[i] = match(words[i], trieNode);
        }
        return String.join(" ", ans);
    }

    private String match(String word, TrieNode node) {

        int i = 0;
        while (node != null && !node.end && i < word.length()) {
            char ch = word.charAt(i++);
            int loc = ch - 'a';
            node = node.children[loc];
        }
        if (node == null) {
            return word;
        }
        return word.substring(0, i);
    }

    private void buildTrie(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int loc = ch - 'a';
            if (node.children[loc] == null) {
                node.children[loc] = new TrieNode();
            }
            node = node.children[loc];
        }
        node.end = true;
    }
}

class TrieNode {
    boolean end;
    TrieNode[] children;

    TrieNode() {
        children = new TrieNode[26];
    }
}


