package main

func slowestKey(releaseTimes []int, keysPressed string) byte {
	max := releaseTimes[0]
	char := keysPressed[0]
	var temp int
	for i := 1; i < len(releaseTimes); i++ {
		temp = releaseTimes[i] - releaseTimes[i-1]
		if temp > max {
			max = temp
			char = keysPressed[i]
		} else if temp == max {
			if char < keysPressed[i] {
				char = keysPressed[i]
			}
		}
	}

	return char
}

func main() {

}
