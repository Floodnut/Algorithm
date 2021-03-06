let fs = require('fs');
class Node{
	constructor(data){
		this.data=data;
		this.link=null;
}}
class Stack{
	constructor(){
		this.tail=null;
		this.head=null;
		this.length=0;
	}
	top(){
		return this.tail;
	}
	push(data){
		const nd = new Node(data);
		if(this.length===0){
			this.tail=nd;
			this.head=nd;
		}
		else{
			const pt = this.tail;
			this.tail = nd;
			this.tail.link= pt;
		}
		this.length++;
	}
	pop(){
		if(!this.tail){
			return -1;
		}
		else{
			if(this.tail === this.head){
				this.head = null;
			}
			this.tail = this.tail.link;
			this.length--;
			return this.tail.data;
		}
	}
}
let ip = fs.readFileSync('/dev/stdin').toString().split('\n');
const baekjoon = new Stack();
for(var i = 0;i<ip;i++){
	let input = fs.readFileSync('/dev/stdin').toString().split('\n');
	if(/[push]/.test(input)==true){
		let parse=input.replace(/[^0-9]/g,'');
		baekjoon.push(parse);
	}
	else if(input == "pop") console.log(baekjoon.pop());
	else if(input == "size") console.log(baekjoon.length());
	else if(input == "empty"){
		if(baekjoon.length()==0) console.log(1);
		else console.log(0);
	}
	else if(input=="top") console.log(baekjoon.top());
}
