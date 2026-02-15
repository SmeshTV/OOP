package lab1;

public class MinecraftPlayer {

    // Типы инструментов которые игрок может держать в руке
    public enum ToolType {
        PICKAXE,
        AXE,
        SWORD,
        SHOVEL,
        NONE
    }

    // Константы, одинаковые для всех
    public static final int MAX_HEALTH = 20;
    public static final int MAX_INVENTORY_SLOTS = 36;
    public static final int DEFAULT_HUNGER = 20;

    // Сколько всего игроков зашло
    private static int onlinePlayers = 0;

    // Неизменяемые характеристики
    private final String username;
    private final long firstJoinTime;

    // Изменяемые поля
    private int health;
    private int hunger;
    private ToolType currentTool;
    private boolean isCreativeMode;

    // Конструктор - здесь всё инициализирует и выводит
    public MinecraftPlayer(String username) {
        this.username = username;
        this.firstJoinTime = System.currentTimeMillis();
        this.health = MAX_HEALTH;
        this.hunger = DEFAULT_HUNGER;
        this.currentTool = ToolType.NONE;
        this.isCreativeMode = false;

        // username
        onlinePlayers++;
        System.out.println(username + " has joined the world. Online: " + onlinePlayers);
    }

    // Статический блок - выполняется один раз
    static {
        System.out.println("Minecraft world loaded!");
    }

    // Перегруженные методы - урон
    public void damage(int hearts) {
        health = Math.max(0, health - hearts * 2);
        System.out.println(username + " took damage! Health: " + health);
    }

    public void damage(double hearts) {
        int intDamage = (int) Math.ceil(hearts * 2);
        damage(intDamage);
    }

    // Перегруженные методы - еда
    public void eat(int hungerRestored) {
        hunger = Math.min(DEFAULT_HUNGER, hunger + hungerRestored);
        System.out.println(username + " ate food. Hunger: " + hunger);
    }

    public void eat(String foodName) {
        switch (foodName.toLowerCase()) {
            case "steak"   -> eat(8);
            case "bread"   -> eat(5);
            case "apple"   -> eat(4);
            default        -> System.out.println("Unknown food: " + foodName);
        }
    }

    public void switchTool(ToolType tool) {
        currentTool = tool;
        System.out.println(username + " is now holding: " + tool);
    }

    public void toggleCreative() {
        isCreativeMode = !isCreativeMode;
        System.out.println(username + " switched to mode: " +
                           (isCreativeMode ? "creative" : "survival"));
    }

    // Геттеры для read-only полей
    public String getUsername() {
        return username;
    }

    public long getFirstJoinTime() {
        return firstJoinTime;
    }

    public int getHealth() {
        return health;
    }

    public static int getOnlinePlayers() {
        return onlinePlayers;
    }

    @Override
    public String toString() {
        return username + " | Health: " + health +
               " | Hunger: " + hunger +
               " | Tool: " + currentTool +
               " | Mode: " + (isCreativeMode ? "creative" : "survival");
    }

    // Тест
    public static void main(String[] args) {
        MinecraftPlayer steve = new MinecraftPlayer("Steve");
        MinecraftPlayer alex = new MinecraftPlayer("Alex");

        steve.damage(3);           // 3 damage
        alex.damage(2.5);          // 2.5 hearts

        steve.eat("steak");
        alex.eat(6);

        steve.switchTool(ToolType.SWORD);
        alex.toggleCreative();

        System.out.println("\n" + steve);
        System.out.println(alex);

        System.out.println("Players online: " + MinecraftPlayer.getOnlinePlayers());
    }
}