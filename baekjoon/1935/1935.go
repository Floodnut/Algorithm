package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
	"strconv"
)

type Stack struct {
	items []float32
}

func (s *Stack) Push(item float32) {
	s.items = append(s.items, item)
}

func (s *Stack) Pop() float32 /*, errors*/ {
	dLen := len(s.items)
	/*
		if dLen == 0 {
			return -1, errors.New("No Data")
		}*/
	item, items := s.items[dLen-1], s.items[0:dLen-1]
	s.items = items
	return item //, nil
}

func postfix(notation string, num []int) float32 {
	s := Stack{}
	var tmp1, tmp2 float32
	for i := 0; i < len(notation); i++ {
		if notation[i] == 43 { //+
			tmp1 = s.Pop()
			tmp2 = s.Pop()
			s.Push(tmp1 + tmp2)
			//fmt.Printf("[+] ")
			//fmt.Println(tmp1, tmp2, tmp1+tmp2, notation[i])
		} else if notation[i] == 45 { //-
			tmp1 = s.Pop()
			tmp2 = s.Pop()
			s.Push(tmp2 - tmp1)
			//fmt.Printf("[-] ")
			//fmt.Println(tmp1, tmp2, tmp1+tmp2, notation[i])
		} else if notation[i] == 42 { //*
			tmp1 = s.Pop()
			tmp2 = s.Pop()
			s.Push(tmp1 * tmp2)
			//fmt.Printf("[*] ")
			//fmt.Println(tmp1, tmp2, tmp1*tmp2, notation[i])
		} else if notation[i] == 47 { // /
			tmp1 = s.Pop()
			tmp2 = s.Pop()
			s.Push(tmp2 / tmp1)
			//fmt.Printf("[/] ")
			//fmt.Println(tmp1, tmp2, tmp1/tmp2, notation[i])
		} else {
			s.Push(float32(num[notation[i]-65]))
		}
	}
	return s.Pop()
}

func main() {
	var n int
	nums := []int{}
	var compute string
	scanner := bufio.NewScanner(os.Stdin)
	scanner.Split(bufio.ScanWords)
	fmt.Scan(&n)
	fmt.Scan(&compute)
	for i := 0; i < n; i++ {
		scanner.Scan()
		k, _ := strconv.Atoi(scanner.Text())
		nums = append(nums, k)
	}
	//fmt.Println(nums)
	rst := math.Trunc(float64(postfix(compute, nums)*100)) / 100
	prt := fmt.Sprintf("%.2f", rst)

	fmt.Println(prt)
}
