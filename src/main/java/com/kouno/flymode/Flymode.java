package com.kouno.flymode;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Flymode extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getLogger().info("Flymode plugin enabled!");
        getServer().getPluginManager().registerEvents(this, this);
    }

    @Override
    public void onDisable() {
        getLogger().info("Flymode plugin disabled!");
    }

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        // コマンドを送信したプレイヤーを取得する
        Player player = event.getPlayer();

        // 404kit.flyのパーミション持ってるかチェック
        if (!player.hasPermission("404kit.fly")) {
            // If the player does not have permission, cancel the command event
            event.setCancelled(true);
            player.sendMessage("You do not have permission to use this command.");
            return;
        }

        //コマンドが「/fly on」または「/fly off」かどうかを確認します
        if (event.getMessage().equalsIgnoreCase("/fly on")) {
            // コマンドイベントをキャンセル
            event.setCancelled(true);

            // プレイヤーの飛行モードを true に設定します
            player.setAllowFlight(true);

            // 飛行モードを示すメッセージをプレイヤーに送信する
            player.sendMessage("START FLY HACK");

        } else if (event.getMessage().equalsIgnoreCase("/fly off")) {
            // コマンドイベントをキャンセル
            event.setCancelled(true);

            // プレイヤーのフライト モードを false に設定する
            player.setAllowFlight(false);

            // 飛行モードを示すメッセージをプレイヤーに送信する
            player.sendMessage("NO SIGNAL");
        }
    }
}