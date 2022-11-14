package com.d205.data.repository.feed

import android.graphics.Bitmap
import android.util.Log
import androidx.paging.PagingSource
import com.d205.data.mapper.mapperFeedResponseToFeed
import com.d205.data.repository.feed.local.FeedLocalDataSource
import com.d205.data.repository.feed.remote.FeedRemoteDataSource
import com.d205.domain.model.mypage.Feed
import com.d205.domain.repository.paging.FeedRepository
import com.d205.domain.utils.ResultState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okio.BufferedSink
import javax.inject.Inject

private const val TAG = "FeedRepositoryImpl"

class FeedRepositoryImpl @Inject constructor(
    private val feedRemoteDataSource: FeedRemoteDataSource,
    private val feedLocalDataSource: FeedLocalDataSource
): FeedRepository {

    override suspend fun getUserFeeds(
        page: Int,
        pageSize: Int
    ): Flow<ResultState<PagingSource.LoadResult<Int, Feed>>> = flow {
        Log.d(TAG, "joinUser: Loading")
        emit(ResultState.Loading)

        feedRemoteDataSource.getUserFeeds(page, pageSize).collect { it ->
            Log.d(TAG, "getUserStoryList: $it")
            emit(ResultState.Success(PagingSource.LoadResult.Page(
                data = it.result.map { feedResponse ->
                    mapperFeedResponseToFeed(feedResponse)
                },
                prevKey = if(page == 0) null else page - 1,
                nextKey = if(page == it.totalPage) null else page + 1
            )))
        }
    }.catch { e ->
        emit(ResultState.Error(e))
    }

    override suspend fun createFeed(
        feedImageBitmap: Bitmap,
        content: String
    ): Flow<ResultState<Boolean>> = flow<ResultState<Boolean>> {
        Log.d(TAG, "createFeed: Loading")
        emit(ResultState.Loading)

        val bitmapRequestBody = feedImageBitmap?.let {
            BitmapRequestBody(it)
        }
        val fileName = "feed/" + System.currentTimeMillis().toString()+".png"
        val imageFileBody : MultipartBody.Part = MultipartBody.Part.createFormData("img", fileName, bitmapRequestBody!!)

//        val json = Gson().toJson(content)
//        val feedBody = RequestBody.create(MediaType.parse("application/json; charset=utf-8"), json)
//        val contentResultBody = RequestBody.create(MediaType.parse("text/plain"), content)
        val contentBody = MultipartBody.Part.createFormData("content", content.toString())

        feedRemoteDataSource.createFeed(imageFileBody, contentBody).collect{
            Log.d(TAG, "createFeed: collect  success : $it")
            emit(ResultState.Success(it))
        }

    }.catch { e ->
        emit(ResultState.Error(e))
        Log.d(TAG, "createFeed success fail: $e")
    }

    inner class BitmapRequestBody(private val bitmap: Bitmap) : RequestBody() {
        override fun contentType(): MediaType = MediaType.parse("image/*")!!
        override fun writeTo(sink: BufferedSink) {
            bitmap.compress(Bitmap.CompressFormat.JPEG, 99, sink.outputStream())
        }
    }
}