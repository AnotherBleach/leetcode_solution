package com.another.leetcode.trie;

import java.util.HashMap;
import java.util.Map;


public class MagicDictionary {
    Trie tree;

    public MagicDictionary() {

    }

    public void buildDict(String[] dictionary) {
        tree = new Trie(dictionary);
    }

    public boolean search(String searchWord) {
        return tree.search(searchWord);
    }


    class Node{
        Map<Character,Node>children;
        Node(){
            children=new HashMap<>();
        }
        boolean isWord=false;
    }
    class Trie{

        Node root;
        public Trie(String[] dict){
            root = new Node();
            for(int i=0;i<dict.length;i++){
                this.insert(dict[i]);
            }


        }
        public boolean search(String searchWord){

            return this.search(root,searchWord,0,0);

        }

        public boolean search(Node currentNode,String searchWord,int start,int diff){

            if(currentNode==null)return false;
            if(start>=searchWord.length())return diff==1 && currentNode.isWord;

            if(diff==0){
                char c=searchWord.charAt(start);
                for(Map.Entry<Character,Node>entry:currentNode.children.entrySet()){
                    Character key = entry.getKey();
                    Node val = entry.getValue();
                    if(search(val,searchWord,start+1,key==c?0:1))return true;

                }
                return false;

            }else{

                char c= searchWord.charAt(start);
                Node child = currentNode.children.get(c);
                if(child==null)return false;
                return search(child,searchWord,start+1,diff);

            }

        }

        public void insert(String word){

            Node current = root;
            for(int i=0;i<word.length();i++){
                char c = word.charAt(i);
                if(current.children.get(c)!=null){
                    current=current.children.get(c);
                }else{
                    Node newNode = new Node();
                    current.children.put(c,newNode);
                   current=newNode;
                }
            }
            current.isWord=true;
        }

    }

    public static void main(String[] args) {
        MagicDictionary magicDictionary = new MagicDictionary();
        magicDictionary.buildDict(new String[]{"hello", "leetcode","hallo"});

        System.out.println(magicDictionary.search("hello")); // 返回 False
        System.out.println(magicDictionary.search("hhllo")); // 将第二个 'h' 替换为 'e' 可以匹配 "hello" ，所以返回 True
        System.out.println(magicDictionary.search("hell")); // 返回 False
        System.out.println(magicDictionary.search("leetcoded")); // 返回 False

    }
}