package main

func singleNumber(nums []int) []int {

	sum := 0
	for _, number := range nums {
		sum ^= number
	}
	k := -1
	for i := 31; i >= 0; i-- {
		if (sum>>i)&1 == 1 {
			k = i
			break
		}
	}
	result := make([]int, 2)
	for _, number := range nums {

		if (number>>k)&1 == 1 {
			result[1] ^= number
		} else {
			result[0] ^= number
		}
	}
	return result
}
func main() {

}
