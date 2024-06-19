var priority = 8
var combatPower = 0.0
var attributeName = "测试死亡属性"
var attributeType = "UPDATE"
var placeholder = "AAAA"

function onLoad(attr) {
	attr.setSkipFilter(true);
	return attr;
}

function runDeath(event) {
	event.getEntity().sendMessage("哈哈，有小丑死了");
	return false;
}

function runKill(event){
	var entity = event.getEntity().getKiller();
	entity.setHealth(Math.min(entity.getMaxHealth(), entity.getHealth() + 2));
	return false;
}