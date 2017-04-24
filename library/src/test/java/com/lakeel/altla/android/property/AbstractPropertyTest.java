package com.lakeel.altla.android.property;

import org.junit.Test;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public final class AbstractPropertyTest {

    @Test
    public void addOnValueChangedListener() {
        final AbstractProperty property = new AbstractProperty() {
            @Nullable
            @Override
            public Object getValue() {
                return null;
            }

            @Override
            public void setValue(@Nullable Object value) {
            }
        };

        final MockOnValueChangedListener listener = new MockOnValueChangedListener();
        property.addOnValueChangedListener(listener);
        property.raiseOnValueChanged();

        assertTrue(listener.invoked);
    }

    @Test
    public void removeOnValueChangedListener() {
        final AbstractProperty property = new AbstractProperty() {
            @Nullable
            @Override
            public Object getValue() {
                return null;
            }

            @Override
            public void setValue(@Nullable Object value) {
            }
        };

        final MockOnValueChangedListener listener = new MockOnValueChangedListener();
        property.addOnValueChangedListener(listener);
        property.removeOnValueChangedListener(listener);
        property.raiseOnValueChanged();

        assertFalse(listener.invoked);
    }

    @Test
    public void clearOnValueChangedListeners() {
        final AbstractProperty property = new AbstractProperty() {
            @Nullable
            @Override
            public Object getValue() {
                return null;
            }

            @Override
            public void setValue(@Nullable Object value) {
            }
        };

        final MockOnValueChangedListener listener = new MockOnValueChangedListener();
        property.addOnValueChangedListener(listener);
        property.clearOnValueChangedListeners();
        property.raiseOnValueChanged();

        assertFalse(listener.invoked);
    }

    private final class MockOnValueChangedListener implements Property.OnValueChangedListener {

        private boolean invoked;

        @Override
        public void onValueChanged(@NonNull Property sender) {
            invoked = true;
        }
    }
}
