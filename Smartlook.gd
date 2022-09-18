extends Node

var Smartlook = null

func _ready():
  if Engine.has_singleton("SmartlookPlugin"):
    Smartlook = Engine.get_singleton("SmartlookPlugin")

# -------------------------------------------
# Initialize
# -------------------------------------------
func init():
  if Smartlook:
    Smartlook.init()

func startRecord():
  if Smartlook:
    Smartlook.startRecord()