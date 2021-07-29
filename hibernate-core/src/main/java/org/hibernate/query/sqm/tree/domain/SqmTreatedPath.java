/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.query.sqm.tree.domain;

import org.hibernate.metamodel.model.domain.EntityDomainType;
import org.hibernate.query.sqm.SqmPathSource;

/**
 * @author Steve Ebersole
 */
public interface SqmTreatedPath<T, S extends T> extends SqmPathWrapper<T, S> {
	EntityDomainType<S> getTreatTarget();

	@Override
	default SqmPathSource<S> getNodeType() {
		return getTreatTarget();
	}

	@Override
	SqmPath<T> getWrappedPath();
}