#include <iostream>
#include <vector>
#include <queue>
#include <tuple>
#include <map>
#include <string>
using namespace std;

int floyd[201][201];
int board[201][201];

int main() {
	int n, m;
	string ans = "YES";
	
	cin >> n >> m;

	fill(&floyd[0][0], &floyd[200][201], 1e9);

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> floyd[i][j];
			
			if (i == j) floyd[i][j] = 0;

			if (i != j && floyd[i][j] == 0) 
				floyd[i][j] = 1e9;
		}
	}

	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if(floyd[i][j] > floyd[i][k] + floyd[k][j])
					floyd[i][j] = floyd[i][k] + floyd[k][j];
			}
		}
	}

	int st, en;
	cin >> st;

	st--;

	for (int i = 0; i < m - 1; i++) {
		cin >> en;

		en--;

		if (floyd[st][en] == 1e9) {
			ans = "NO";
			break;
		}

		st = en;
	}

	cout << ans << '\n';

	return 0;
}