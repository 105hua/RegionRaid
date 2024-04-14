# 🔨 RegionRaid

RegionRaid is a simple plugin that allows you to disable raids in WorldGuard Regions. It does this by
adding a region flag called `raid-enabled`, which you can either `allow` or `deny`.

If a player attempts to start a raid, in which the village center falls within a region that has
`raid-enabled` set to `deny`, the plugin will prevent the raid from starting. In the case that the flag
is set during a raid, additional waves will be prevented from spawning.

## ⬇️ Installation

Before you are able to use this plugin, you will need to have WorldGuard v7.0.9 installed. In addition
to this, you must also have a Paper Server that is running Minecraft 1.20.4.

Head over to the releases page of this repository and download the latest version of this plugin. From
there, drop the downloaded jar file into your server's `plugins` folder and restart the server.

## 💻 Usage

To use this plugin, please create a region that encases the area that you'd like to disable raids in, if
you have not done so already. Once you have created the region, you can set the `raid-enabled` flag
to either `allow` or `deny` by running `/rg flag <region_name> raid-enabled <option>`.

If you would like to test the region flag, you may also run `/rr test` to see if the flag is set as you
wish.

## ❗ Permissions

To use the `/rrtest` command, you must have the `regionraid.test` permission.

## 📜 Information for Developers

RegionRaid includes a RaidSuppressedEvent, which is Cancellable. When the event is cancelled, the
plugin will make no attempts to suppress raids, even if the `raid-enabled` flag is set to `deny` for
the given region. The event extends on `RaidEvent`, which includes a SuppressType enum that will either
be `TRIGGER` or `WAVE`, indicating whether it will suppress the `RaidTriggerEvent` or
`RaidSpawnWaveEvent`.

There is also static access to the `RegionRaid#raidEnabled()` overload method, which allows you to check
if a flag is set at a given `Location`, or you can pass a `Raid` instance and it will use
`Raid#getLocation()` to check the flag.

## 🌀 Credits

- **OffLuffy**: Original author of the plugin.
- **105hua**: Converting the project to Gradle and porting it to Minecraft 1.20.4.