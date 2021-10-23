package com.ids.projections;

import java.time.LocalDate;

public interface FactureClientProjection {
	
	Long getId();
	LocalDate getDateFacturation();
	IdNomClient getClient();

}
