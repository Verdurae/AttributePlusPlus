## AttributePlusPlus
### 自述
为AttributePlus提供了更多属性触发器，免费公开源码和构建以供学习和参考
### 使用
如示例文件一样，复制创建多个属性，这些属性文件和AP的属性扩展写法类似  
每个属性都可以写以下方法，也可以不写，不写则不会触发，没有属性类型的要求
* runDeath(event)
  * 生物死亡时执行，实参event为EntityDeathEvent
  * 示例文件为生物死亡时向生物发送一条消息
* runKill(event)
  * 生物击杀一个生物时执行，实参event为EntityDeathEvent
  * 示例文件中为生物击杀一个生物时，回复2血量（直接回复，没有触发事件，但你也可以自己触发事件）
### 开源和许可
依据[这个页面](https://choosealicense.com/no-permission/)，此项目开源协议为**no-permission**：
* When you make a creative work (which includes code), the work is under exclusive copyright by default. Unless you include a license that specifies otherwise, nobody else can copy, distribute, or modify your work without being at risk of take-downs, shake-downs, or litigation. Once the work has other contributors (each a copyright holder), “nobody” starts including you.

  当您制作创意作品（包括代码）时，默认情况下，该作品受独家版权保护。除非您包含另有规定的许可证，否则任何其他人都不能复制、分发或修改您的作品，而不会面临被删除、改组或诉讼的风险。一旦作品有其他贡献者（每个贡献者都是版权所有者），“没有人”开始包括你。
* Even in the absence of a license file, you may grant some rights in cases where you publish your source code to a site that requires accepting terms of service. For example, if you publish your source code in a public repository on GitHub, you have accepted the Terms of Service, by which you allow others to view and fork your repository. Others may not need your permission if limitations and exceptions to copyright apply to their particular situation. Neither site terms nor jurisdiction-specific copyright limitations are sufficient for the kinds of collaboration that people usually seek on a public code host, such as experimentation, modification, and sharing as fostered by an open source license.
  
  即使没有许可证文件，您也可以在将源代码发布到需要接受服务条款的站点时授予某些权限。例如，如果您在 GitHub 上的公共仓库中发布源代码，则您已接受服务条款，根据该条款，您允许其他人查看和分叉您的仓库。如果版权的限制和例外适用于他们的特定情况，其他人可能不需要您的许可。无论是网站条款还是特定司法管辖区的版权限制都不足以满足人们通常在公共代码主机上寻求的协作类型，例如开源许可证所促进的实验、修改和共享。
  
  根据Github服务条款，我已授权此项目具有公开查看的权利，保留其余所有权利
* 在保留所有权利之外，我声明授权非商业性服务器默认具有免费使用此项目的权利。追溯使用者的责任。商业性服务器应当与我联系并取得许可，当然非商业性服务器也可以与我联系，这方便我统计数据和采集建议（此项目本身不含bstats或远程信息采集手段）
  使用本项目的服务器非具有许可使用，或谎报信息获得许可使用，或违反EULA等协议、当地政府法律法规等，需免除我自身所有连带责任，并有权追溯其相关责任和损失
