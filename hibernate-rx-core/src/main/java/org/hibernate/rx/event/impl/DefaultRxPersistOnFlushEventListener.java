package org.hibernate.rx.event.impl;

import org.hibernate.internal.util.collections.IdentitySet;
import org.hibernate.rx.engine.impl.CascadingAction;
import org.hibernate.rx.engine.impl.CascadingActions;

/**
 * A reactific {@link org.hibernate.event.internal.DefaultPersistOnFlushEventListener}.
 */
public class DefaultRxPersistOnFlushEventListener extends DefaultRxPersistEventListener {
	@Override
	protected CascadingAction<IdentitySet> getCascadeRxAction() {
		return CascadingActions.PERSIST_ON_FLUSH;
	}
}