package main

import (
	"fmt"
)

func reverseString(s string) string {
	runes := []rune(s)
	for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
		runes[i], runes[j] = runes[j], runes[i]
	}
	return string(runes)
}

func longestPalindrome(s string) string {
	var resultMatch string

	if len(s) > 1000 {
		return resultMatch
	}

	strSplit := []rune(s)
	lenStr := len(strSplit)

	collectMatch := make(map[string]int)
	for i := 0; i < lenStr; i++ {
		for j := i + 1; j <= lenStr; j++ {
			getStr := strSplit[i:j]
			strJoin := string(getStr)

			if _, ok := collectMatch[strJoin]; ok {
				continue
			}

			strJoinReverse := reverseString(strJoin)
			if strJoin == strJoinReverse {
				if len(strJoin) > len(resultMatch) {
					resultMatch = strJoin
					collectMatch[strJoin] = i
				}
			}
		}
	}

	return resultMatch
}

func run_longestPalindrome() {
	// start := time.Now()
	fmt.Println(longestPalindrome("cbbd"))
	// fmt.Println(longestPalindrome("c"))
	fmt.Println(longestPalindrome("ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy"))
	// d := time.Since(start)
	// fmt.Println(d)
}
