/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later
 * See the lgpl.txt file in the root directory or http://www.gnu.org/licenses/lgpl-2.1.html
 */
package org.hibernate.sql.results.internal.domain.collection;

import org.hibernate.collection.spi.PersistentCollection;
import org.hibernate.sql.results.spi.JdbcValuesSourceProcessingOptions;
import org.hibernate.sql.results.spi.CollectionInitializer;
import org.hibernate.sql.results.spi.DomainResultAssembler;
import org.hibernate.sql.results.spi.RowProcessingState;
import org.hibernate.type.descriptor.java.spi.JavaTypeDescriptor;

/**
 * @author Steve Ebersole
 */
public class PluralAttributeAssemblerImpl implements DomainResultAssembler {
	private final CollectionInitializer initializer;

	public PluralAttributeAssemblerImpl(CollectionInitializer initializer) {
		this.initializer = initializer;
	}

	@Override
	public Object assemble(
			RowProcessingState rowProcessingState,
			JdbcValuesSourceProcessingOptions options) {
		PersistentCollection collectionInstance = initializer.getCollectionInstance();
		if ( collectionInstance == null ) {
			return null;
		}
		return collectionInstance.getValue();
	}

	@Override
	public JavaTypeDescriptor getJavaTypeDescriptor() {
		return initializer.getFetchedAttribute().getJavaTypeDescriptor();
	}
}
