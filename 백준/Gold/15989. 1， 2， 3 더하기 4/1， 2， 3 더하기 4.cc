#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

int main() {
	
	int tc;
	cin >> tc;

	for (int t = 0; t < tc; t++) {
		int n;
		cin >> n;

		int dp[10001] = { 0, };

		for (int i = 1; i <= 3; i++) {
			dp[0] = 1;
			for (int j = i; j <= n; j++)
				dp[j] += dp[j - i];
		}

		cout << dp[n] << '\n';
	}

	return 0;
}