package functionCall

// issue #812
func f1(s string, arg ...int) int {
	return 0
}
func f11()(int,int){
	return 0,0
}

func f12()(int,float64){
	return 0,0
}

func bad() {
	a := 1

	f1("" , /*begin*/a/*end.Expression type mismatch, the expected type is []int*/ ...)

}
func good1() {
	f1("", []int{1, 2, 3}...)
	f1("", f1("", []int{1, 2, 3}...))
}

func f2(arg ...int) int {
	return 0
}
func bad2(){
	f2(/*begin*/f11()/*end.Expression type mismatch, the expected type is []int*/ ...) //TODO good error reporting like golang compiler
	//f2(f12()) //TODO find this kind of error.
}

func good2() {
	f2()
	f2(1)
	f2(1, 2)
	f2([]int{1, 2, 3}...)
	f2(f2([]int{1, 2, 3}...))
	f2(f11())
}

/*
TODO finish it when type system can do it.
wait for interface isIdentical check and type assignability check.
func f3(arg ...interface{}) int {
	return 0
}
func good3() {
	a := []interface{}{}
	f3(a...)
}

type t1 string

func f4(arg ...t1) int {
	return 0
}
func bad4() {
	f4([]string{}...)
}
func good4() {
	a := []t1{}
	f4(a...)
}
*/