package com.balkan.nautical.systems.utils;

import java.time.LocalDateTime;

public interface Base {

	public Long getVersion();

	public void setVersion(final Long version);

	public LocalDateTime getCreatedDate();

	public void setCreatedDate(final LocalDateTime createdDate);

	public String getCreatedBy();

	public void setCreatedBy(final String createdBy);

	public LocalDateTime getLastModifiedDate();

	public void setLastModifiedDate(final LocalDateTime lastModifiedDate);

	public String getLastModifiedBy();

	public void setLastModifiedBy(final String lastModifiedBy);

}
