package main

import (
	"bytes"
	"fmt"
)

func toLowerCase(s string) string {
	length := len(s)
	var buf bytes.Buffer
	for i := 0; i < length; i++ {
		if s[i] >= 'A' && s[i] <= 'Z' {
			buf.WriteString(string(rune(s[i] + 32)))
		} else {
			buf.WriteString(string(rune(s[i])))
		}
	}

	return buf.String()

}
func main() {
	fmt.Print(toLowerCase("Hello"))
}
