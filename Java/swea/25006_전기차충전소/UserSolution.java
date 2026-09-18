class UserSolution {
	int n;
	int[] mCost;
	int k;
	int[] mId;
	int[] sCity;
	int[] eCity;
	int[] mDistance;

	public void init(int N, int mCost[], int K, int mId[], int sCity[], int eCity[], int mDistance[]) {
		this.n = N;
		this.mCost = new int[n];
		this.k = K;
		this.mId = new int[n];
		this.sCity = new int[n];
		this.eCity = new int[n];
		this.mDistance = new int[n];
		return;
	}

	public void add(int mId, int sCity, int eCity, int mDistance) {
		return;
	}

	public void remove(int mId) {
		return;
	}

	public int cost(int sCity, int eCity) {
		return 0;
	}
}