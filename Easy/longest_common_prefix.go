package main

import (
	"fmt"
	"sort"
	"strings"
)

func longestCommonPrefix(strs []string) string {
	if len(strs) == 0 || len(strs) > 200 {
		return ""
	}

	sort.Slice(strs, func(i, j int) bool {
		return len(strs[i]) < len(strs[j])
	})

	lenShortText := len(strs[0])
	collectPrefix := []string{}

	for i := 0; i < lenShortText; i++ {
		if len(collectPrefix) == i {
			collectPrefix = append(collectPrefix, string(strs[0][i]))
		}

		if i > len(collectPrefix) || len(collectPrefix) == 0 {
			break
		}

		for _, text := range strs {
			if text == "" {
				continue
			}

			if string(text[i]) != collectPrefix[i] {
				collectPrefix = collectPrefix[:len(collectPrefix)-1]
				break
			}
		}
	}

	return strings.Join(collectPrefix, "")
}

func run_longestCommonPrefix() {
	fmt.Println(longestCommonPrefix([]string{"flower", "flow", "flight"}))             // fl
	fmt.Println(longestCommonPrefix([]string{"flower", "flow", ""}))                   // fl
	fmt.Println(longestCommonPrefix([]string{"flower", "flower", "flower", "flower"})) // flower
	fmt.Println(longestCommonPrefix([]string{"ab", "a"}))                              // a
	fmt.Println(longestCommonPrefix([]string{"", ""}))                                 //
	fmt.Println(longestCommonPrefix([]string{"dog", "racecar", "car"}))                //
	fmt.Println(longestCommonPrefix([]string{"a"}))                                    // a
}
