package part02;

public enum SupRegion {
	UNITED_KINGDOM {
		@Override
		String getRegionasString() {
			return "United Kingdom";
		}
	}, EUROPE {
		@Override
		String getRegionasString() {
			return "Europe";
		}
	}, OUTSIDE_EU {
		@Override
		String getRegionasString() {
			return "Outside Europe";
		}
	};
	abstract String getRegionasString();
}
