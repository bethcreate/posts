package com.example.myposts

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.w3c.dom.Comment

class RvCommentsAdapter(var commentList:List<Comment>):RecyclerView.Adapter<CommentsViewHolder> (){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CommentsViewHolder {
        var itemView=LayoutInflater.from(parent.context)
            .inflate(R.layout.activity_post_adapter,parent,false)
        return CommentsViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CommentsViewHolder, position: Int) {
        var currentComment=commentList.get(position)
        holder.tvpostId.text=currentComment.postId.toString()
        holder.tvcommentEmail.text=currentComment.Email
        holder.tvcommentName.text=currentComment.Name
        holder.tvcommentbody.text=currentComment.body
        holder.tvcommentId.text=currentComment.Id


    }

    override fun getItemCount(): Int {
        return commentList.size
    }
}
class CommentsViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
    var tvpostId=itemView.findViewById<TextView>(R.id.tvpostId)
    var tvcommentEmail=itemView.findViewById<TextView>(R.id.tvcommentEmail)
    var tvcommentName=itemView.findViewById<TextView>(R.id.tvCommentName)
    var tvcommentbody=itemView.findViewById<TextView>(R.id.tvcommentbody)
    var tvcommentId=itemView.findViewById<TextView>(R.id.tvCommentId)

}