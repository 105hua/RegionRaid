package org.gradle.accessors.dm;

import org.gradle.api.NonNullApi;
import org.gradle.api.artifacts.MinimalExternalModuleDependency;
import org.gradle.plugin.use.PluginDependency;
import org.gradle.api.artifacts.ExternalModuleDependencyBundle;
import org.gradle.api.artifacts.MutableVersionConstraint;
import org.gradle.api.provider.Provider;
import org.gradle.api.model.ObjectFactory;
import org.gradle.api.provider.ProviderFactory;
import org.gradle.api.internal.catalog.AbstractExternalDependencyFactory;
import org.gradle.api.internal.catalog.DefaultVersionCatalog;
import java.util.Map;
import org.gradle.api.internal.attributes.ImmutableAttributesFactory;
import org.gradle.api.internal.artifacts.dsl.CapabilityNotationParser;
import javax.inject.Inject;

/**
 * A catalog of dependencies accessible via the {@code libs} extension.
 */
@NonNullApi
public class LibrariesForLibs extends AbstractExternalDependencyFactory {

    private final AbstractExternalDependencyFactory owner = this;
    private final ComLibraryAccessors laccForComLibraryAccessors = new ComLibraryAccessors(owner);
    private final VersionAccessors vaccForVersionAccessors = new VersionAccessors(providers, config);
    private final BundleAccessors baccForBundleAccessors = new BundleAccessors(objects, providers, config, attributesFactory, capabilityNotationParser);
    private final PluginAccessors paccForPluginAccessors = new PluginAccessors(providers, config);

    @Inject
    public LibrariesForLibs(DefaultVersionCatalog config, ProviderFactory providers, ObjectFactory objects, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) {
        super(config, providers, objects, attributesFactory, capabilityNotationParser);
    }

    /**
     * Group of libraries at <b>com</b>
     */
    public ComLibraryAccessors getCom() {
        return laccForComLibraryAccessors;
    }

    /**
     * Group of versions at <b>versions</b>
     */
    public VersionAccessors getVersions() {
        return vaccForVersionAccessors;
    }

    /**
     * Group of bundles at <b>bundles</b>
     */
    public BundleAccessors getBundles() {
        return baccForBundleAccessors;
    }

    /**
     * Group of plugins at <b>plugins</b>
     */
    public PluginAccessors getPlugins() {
        return paccForPluginAccessors;
    }

    public static class ComLibraryAccessors extends SubDependencyFactory {
        private final ComDestroystokyoLibraryAccessors laccForComDestroystokyoLibraryAccessors = new ComDestroystokyoLibraryAccessors(owner);
        private final ComSk89qLibraryAccessors laccForComSk89qLibraryAccessors = new ComSk89qLibraryAccessors(owner);

        public ComLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.destroystokyo</b>
         */
        public ComDestroystokyoLibraryAccessors getDestroystokyo() {
            return laccForComDestroystokyoLibraryAccessors;
        }

        /**
         * Group of libraries at <b>com.sk89q</b>
         */
        public ComSk89qLibraryAccessors getSk89q() {
            return laccForComSk89qLibraryAccessors;
        }

    }

    public static class ComDestroystokyoLibraryAccessors extends SubDependencyFactory {
        private final ComDestroystokyoPaperLibraryAccessors laccForComDestroystokyoPaperLibraryAccessors = new ComDestroystokyoPaperLibraryAccessors(owner);

        public ComDestroystokyoLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.destroystokyo.paper</b>
         */
        public ComDestroystokyoPaperLibraryAccessors getPaper() {
            return laccForComDestroystokyoPaperLibraryAccessors;
        }

    }

    public static class ComDestroystokyoPaperLibraryAccessors extends SubDependencyFactory {
        private final ComDestroystokyoPaperPaperLibraryAccessors laccForComDestroystokyoPaperPaperLibraryAccessors = new ComDestroystokyoPaperPaperLibraryAccessors(owner);

        public ComDestroystokyoPaperLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.destroystokyo.paper.paper</b>
         */
        public ComDestroystokyoPaperPaperLibraryAccessors getPaper() {
            return laccForComDestroystokyoPaperPaperLibraryAccessors;
        }

    }

    public static class ComDestroystokyoPaperPaperLibraryAccessors extends SubDependencyFactory {

        public ComDestroystokyoPaperPaperLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>api</b> with <b>com.destroystokyo.paper:paper-api</b> coordinates and
         * with version reference <b>com.destroystokyo.paper.paper.api</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getApi() {
            return create("com.destroystokyo.paper.paper.api");
        }

    }

    public static class ComSk89qLibraryAccessors extends SubDependencyFactory {
        private final ComSk89qWorldguardLibraryAccessors laccForComSk89qWorldguardLibraryAccessors = new ComSk89qWorldguardLibraryAccessors(owner);

        public ComSk89qLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.sk89q.worldguard</b>
         */
        public ComSk89qWorldguardLibraryAccessors getWorldguard() {
            return laccForComSk89qWorldguardLibraryAccessors;
        }

    }

    public static class ComSk89qWorldguardLibraryAccessors extends SubDependencyFactory {
        private final ComSk89qWorldguardWorldguardLibraryAccessors laccForComSk89qWorldguardWorldguardLibraryAccessors = new ComSk89qWorldguardWorldguardLibraryAccessors(owner);

        public ComSk89qWorldguardLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Group of libraries at <b>com.sk89q.worldguard.worldguard</b>
         */
        public ComSk89qWorldguardWorldguardLibraryAccessors getWorldguard() {
            return laccForComSk89qWorldguardWorldguardLibraryAccessors;
        }

    }

    public static class ComSk89qWorldguardWorldguardLibraryAccessors extends SubDependencyFactory {

        public ComSk89qWorldguardWorldguardLibraryAccessors(AbstractExternalDependencyFactory owner) { super(owner); }

        /**
         * Dependency provider for <b>bukkit</b> with <b>com.sk89q.worldguard:worldguard-bukkit</b> coordinates and
         * with version reference <b>com.sk89q.worldguard.worldguard.bukkit</b>
         * <p>
         * This dependency was declared in catalog libs.versions.toml
         */
        public Provider<MinimalExternalModuleDependency> getBukkit() {
            return create("com.sk89q.worldguard.worldguard.bukkit");
        }

    }

    public static class VersionAccessors extends VersionFactory  {

        private final ComVersionAccessors vaccForComVersionAccessors = new ComVersionAccessors(providers, config);
        public VersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com</b>
         */
        public ComVersionAccessors getCom() {
            return vaccForComVersionAccessors;
        }

    }

    public static class ComVersionAccessors extends VersionFactory  {

        private final ComDestroystokyoVersionAccessors vaccForComDestroystokyoVersionAccessors = new ComDestroystokyoVersionAccessors(providers, config);
        private final ComSk89qVersionAccessors vaccForComSk89qVersionAccessors = new ComSk89qVersionAccessors(providers, config);
        public ComVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.destroystokyo</b>
         */
        public ComDestroystokyoVersionAccessors getDestroystokyo() {
            return vaccForComDestroystokyoVersionAccessors;
        }

        /**
         * Group of versions at <b>versions.com.sk89q</b>
         */
        public ComSk89qVersionAccessors getSk89q() {
            return vaccForComSk89qVersionAccessors;
        }

    }

    public static class ComDestroystokyoVersionAccessors extends VersionFactory  {

        private final ComDestroystokyoPaperVersionAccessors vaccForComDestroystokyoPaperVersionAccessors = new ComDestroystokyoPaperVersionAccessors(providers, config);
        public ComDestroystokyoVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.destroystokyo.paper</b>
         */
        public ComDestroystokyoPaperVersionAccessors getPaper() {
            return vaccForComDestroystokyoPaperVersionAccessors;
        }

    }

    public static class ComDestroystokyoPaperVersionAccessors extends VersionFactory  {

        private final ComDestroystokyoPaperPaperVersionAccessors vaccForComDestroystokyoPaperPaperVersionAccessors = new ComDestroystokyoPaperPaperVersionAccessors(providers, config);
        public ComDestroystokyoPaperVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.destroystokyo.paper.paper</b>
         */
        public ComDestroystokyoPaperPaperVersionAccessors getPaper() {
            return vaccForComDestroystokyoPaperPaperVersionAccessors;
        }

    }

    public static class ComDestroystokyoPaperPaperVersionAccessors extends VersionFactory  {

        public ComDestroystokyoPaperPaperVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.destroystokyo.paper.paper.api</b> with value <b>1.14.4-R0.1-SNAPSHOT</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getApi() { return getVersion("com.destroystokyo.paper.paper.api"); }

    }

    public static class ComSk89qVersionAccessors extends VersionFactory  {

        private final ComSk89qWorldguardVersionAccessors vaccForComSk89qWorldguardVersionAccessors = new ComSk89qWorldguardVersionAccessors(providers, config);
        public ComSk89qVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.sk89q.worldguard</b>
         */
        public ComSk89qWorldguardVersionAccessors getWorldguard() {
            return vaccForComSk89qWorldguardVersionAccessors;
        }

    }

    public static class ComSk89qWorldguardVersionAccessors extends VersionFactory  {

        private final ComSk89qWorldguardWorldguardVersionAccessors vaccForComSk89qWorldguardWorldguardVersionAccessors = new ComSk89qWorldguardWorldguardVersionAccessors(providers, config);
        public ComSk89qWorldguardVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Group of versions at <b>versions.com.sk89q.worldguard.worldguard</b>
         */
        public ComSk89qWorldguardWorldguardVersionAccessors getWorldguard() {
            return vaccForComSk89qWorldguardWorldguardVersionAccessors;
        }

    }

    public static class ComSk89qWorldguardWorldguardVersionAccessors extends VersionFactory  {

        public ComSk89qWorldguardWorldguardVersionAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

        /**
         * Version alias <b>com.sk89q.worldguard.worldguard.bukkit</b> with value <b>7.0.1-SNAPSHOT</b>
         * <p>
         * If the version is a rich version and cannot be represented as a
         * single version string, an empty string is returned.
         * <p>
         * This version was declared in catalog libs.versions.toml
         */
        public Provider<String> getBukkit() { return getVersion("com.sk89q.worldguard.worldguard.bukkit"); }

    }

    public static class BundleAccessors extends BundleFactory {

        public BundleAccessors(ObjectFactory objects, ProviderFactory providers, DefaultVersionCatalog config, ImmutableAttributesFactory attributesFactory, CapabilityNotationParser capabilityNotationParser) { super(objects, providers, config, attributesFactory, capabilityNotationParser); }

    }

    public static class PluginAccessors extends PluginFactory {

        public PluginAccessors(ProviderFactory providers, DefaultVersionCatalog config) { super(providers, config); }

    }

}
