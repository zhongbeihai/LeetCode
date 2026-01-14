package dynamic_programming

func maxProfit(prices []int) int {
	profit := make([]int, len(prices))
	hold := make([]int, len(prices))
	profit[0] = 0
	hold[0] = -prices[0]
	for i := 1; i < len(prices); i++ {
		profit[i] = max(hold[i-1]+prices[i], profit[i-1])
		if i >= 2 {
			hold[i] = max(hold[i-1], profit[i-2]-prices[i])
		} else {
			hold[i] = max(hold[i-1], profit[0]-prices[i])
		}
	}
	return profit[len(prices)-1]
}
