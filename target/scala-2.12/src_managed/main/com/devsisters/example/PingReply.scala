// Generated by the Scala Plugin for the Protocol Buffer Compiler.
// Do not edit!
//
// Protofile syntax: PROTO3

package com.devsisters.example



@SerialVersionUID(0L)
final case class PingReply(
    payload: String = ""
    ) extends com.trueaccord.scalapb.GeneratedMessage with com.trueaccord.scalapb.Message[PingReply] with com.trueaccord.lenses.Updatable[PingReply] {
    @transient
    private[this] var __serializedSizeCachedValue: Int = 0
    private[this] def __computeSerializedValue(): Int = {
      var __size = 0
      if (payload != "") { __size += _root_.com.google.protobuf.CodedOutputStream.computeStringSize(2, payload) }
      __size
    }
    final override def serializedSize: Int = {
      var read = __serializedSizeCachedValue
      if (read == 0) {
        read = __computeSerializedValue()
        __serializedSizeCachedValue = read
      }
      read
    }
    def writeTo(`_output__`: _root_.com.google.protobuf.CodedOutputStream): Unit = {
      {
        val __v = payload
        if (__v != "") {
          _output__.writeString(2, __v)
        }
      };
    }
    def mergeFrom(`_input__`: _root_.com.google.protobuf.CodedInputStream): com.devsisters.example.PingReply = {
      var __payload = this.payload
      var _done__ = false
      while (!_done__) {
        val _tag__ = _input__.readTag()
        _tag__ match {
          case 0 => _done__ = true
          case 18 =>
            __payload = _input__.readString()
          case tag => _input__.skipField(tag)
        }
      }
      com.devsisters.example.PingReply(
          payload = __payload
      )
    }
    def withPayload(__v: String): PingReply = copy(payload = __v)
    def getFieldByNumber(__fieldNumber: Int): scala.Any = {
      (__fieldNumber: @_root_.scala.unchecked) match {
        case 2 => {
          val __t = payload
          if (__t != "") __t else null
        }
      }
    }
    def getField(__field: _root_.scalapb.descriptors.FieldDescriptor): _root_.scalapb.descriptors.PValue = {
      require(__field.containingMessage eq companion.scalaDescriptor)
      (__field.number: @_root_.scala.unchecked) match {
        case 2 => _root_.scalapb.descriptors.PString(payload)
      }
    }
    override def toString: String = _root_.com.trueaccord.scalapb.TextFormat.printToUnicodeString(this)
    def companion = com.devsisters.example.PingReply
}

object PingReply extends com.trueaccord.scalapb.GeneratedMessageCompanion[com.devsisters.example.PingReply] {
  implicit def messageCompanion: com.trueaccord.scalapb.GeneratedMessageCompanion[com.devsisters.example.PingReply] = this
  def fromFieldsMap(__fieldsMap: scala.collection.immutable.Map[_root_.com.google.protobuf.Descriptors.FieldDescriptor, scala.Any]): com.devsisters.example.PingReply = {
    require(__fieldsMap.keys.forall(_.getContainingType() == javaDescriptor), "FieldDescriptor does not match message type.")
    val __fields = javaDescriptor.getFields
    com.devsisters.example.PingReply(
      __fieldsMap.getOrElse(__fields.get(0), "").asInstanceOf[String]
    )
  }
  implicit def messageReads: _root_.scalapb.descriptors.Reads[com.devsisters.example.PingReply] = _root_.scalapb.descriptors.Reads{
    case _root_.scalapb.descriptors.PMessage(__fieldsMap) =>
      require(__fieldsMap.keys.forall(_.containingMessage == scalaDescriptor), "FieldDescriptor does not match message type.")
      com.devsisters.example.PingReply(
        __fieldsMap.get(scalaDescriptor.findFieldByNumber(2).get).map(_.as[String]).getOrElse("")
      )
    case _ => throw new RuntimeException("Expected PMessage")
  }
  def javaDescriptor: _root_.com.google.protobuf.Descriptors.Descriptor = MessagesProto.javaDescriptor.getMessageTypes.get(1)
  def scalaDescriptor: _root_.scalapb.descriptors.Descriptor = MessagesProto.scalaDescriptor.messages(1)
  def messageCompanionForFieldNumber(__number: Int): _root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_] = throw new MatchError(__number)
  lazy val nestedMessagesCompanions: Seq[_root_.com.trueaccord.scalapb.GeneratedMessageCompanion[_]] = Seq.empty
  def enumCompanionForFieldNumber(__fieldNumber: Int): _root_.com.trueaccord.scalapb.GeneratedEnumCompanion[_] = throw new MatchError(__fieldNumber)
  lazy val defaultInstance = com.devsisters.example.PingReply(
  )
  implicit class PingReplyLens[UpperPB](_l: _root_.com.trueaccord.lenses.Lens[UpperPB, com.devsisters.example.PingReply]) extends _root_.com.trueaccord.lenses.ObjectLens[UpperPB, com.devsisters.example.PingReply](_l) {
    def payload: _root_.com.trueaccord.lenses.Lens[UpperPB, String] = field(_.payload)((c_, f_) => c_.copy(payload = f_))
  }
  final val PAYLOAD_FIELD_NUMBER = 2
}
