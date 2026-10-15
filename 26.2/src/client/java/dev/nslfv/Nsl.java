package dev.nslfv;

import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.AttributeModifier.Operation;

public class Nsl {
	public static final Identifier ID = Identifier.withDefaultNamespace("effect.slowness");

	public static double val(AttributeInstance in) {
		double b = in.getBaseValue();
		for (AttributeModifier m : in.getModifiers()) if (m.operation() == Operation.ADD_VALUE && !m.id().equals(ID)) b += m.amount();
		double v = b;
		for (AttributeModifier m : in.getModifiers()) if (m.operation() == Operation.ADD_MULTIPLIED_BASE && !m.id().equals(ID)) v += b * m.amount();
		for (AttributeModifier m : in.getModifiers()) if (m.operation() == Operation.ADD_MULTIPLIED_TOTAL && !m.id().equals(ID)) v *= 1.0 + m.amount();
		return in.getAttribute().value().sanitizeValue(v);
	}
}
