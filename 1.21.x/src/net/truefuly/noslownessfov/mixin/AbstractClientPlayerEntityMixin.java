/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  net.minecraft.class_1320
 *  net.minecraft.class_1322
 *  net.minecraft.class_1324
 *  net.minecraft.class_2960
 *  net.minecraft.class_5134
 *  net.minecraft.class_6880
 *  net.minecraft.class_742
 *  org.spongepowered.asm.mixin.Mixin
 *  org.spongepowered.asm.mixin.Unique
 *  org.spongepowered.asm.mixin.injection.At
 *  org.spongepowered.asm.mixin.injection.Redirect
 */
package net.truefuly.noslownessfov.mixin;

import net.minecraft.class_1320;
import net.minecraft.class_1322;
import net.minecraft.class_1324;
import net.minecraft.class_2960;
import net.minecraft.class_5134;
import net.minecraft.class_6880;
import net.minecraft.class_742;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Mixin(value={class_742.class})
public class AbstractClientPlayerEntityMixin {
    @Unique
    private static final class_2960 SLOWNESS_MODIFIER_ID = class_2960.method_60656((String)"effect.slowness");

    @Redirect(method={"method_3118()F"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/AbstractClientPlayerEntity;getAttributeValue(Lnet/minecraft/registry/entry/RegistryEntry;)D"), require=0)
    private double redirectGetAttributeValue121(class_742 player, class_6880<class_1320> attribute) {
        return this.getSpeedValueWithoutSlowness(player, attribute);
    }

    @Redirect(method={"method_3118(ZF)F"}, at=@At(value="INVOKE", target="Lnet/minecraft/client/network/AbstractClientPlayerEntity;getAttributeValue(Lnet/minecraft/registry/entry/RegistryEntry;)D"), require=0)
    private double redirectGetAttributeValue121_10(class_742 player, class_6880<class_1320> attribute) {
        return this.getSpeedValueWithoutSlowness(player, attribute);
    }

    @Unique
    private double getSpeedValueWithoutSlowness(class_742 player, class_6880<class_1320> attribute) {
        class_1322 slownessModifier;
        class_1324 instance;
        if (attribute.equals((Object)class_5134.field_23719) && (instance = player.method_5996(class_5134.field_23719)) != null && (slownessModifier = instance.method_6199(SLOWNESS_MODIFIER_ID)) != null) {
            instance.method_6202(slownessModifier);
            double valWithoutSlowness = instance.method_6194();
            instance.method_26835(slownessModifier);
            return valWithoutSlowness;
        }
        return player.method_45325(attribute);
    }
}

